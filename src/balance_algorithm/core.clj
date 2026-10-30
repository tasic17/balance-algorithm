(ns balance-algorithm.core)

;; Racunanje rizika promene
(defn calculate-risk [dependencies criticality change-size]
  (+ (* dependencies 0.4)
     (* criticality 0.4)
     (* change-size 0.2)))

;; Odredjivanje nivoa rizika
(defn risk-level [risk]
  (cond
    (< risk 30) "Nizak"
    (< risk 60) "Srednji"
    :else "Visok"))

;; Predlaganje testova za promenjenu funkciju
(defn suggest-tests [function-name]
  (cond
    (= function-name "move_enemy")
    ["Proveriti brzinu neprijatelja"
     "Proveriti sudare sa zidovima"
     "Proveriti kretanje oko prepreka"]

    (= function-name "attack_player")
    ["Proveriti napad neprijatelja"
     "Proveriti smanjenje zdravlja igraca"]

    (= function-name "spawn_wave")
    ["Proveriti pojavljivanje neprijatelja"
     "Proveriti zavrsetak talasa"]

    :else
    ["Rucno proveriti promenjenu funkciju"]))

;; Dodatna preporuka na osnovu rizika
(defn risk-recommendation [risk]
  (cond
    (< risk 30) "Dovoljno je osnovno testiranje."
    (< risk 60) "Preporucuje se dodatno testiranje."
    :else "Potrebno je detaljno testiranje!"))

;; Glavni program
(defn -main []
  (let [function-name "move_enemy"
        dependencies 80
        criticality 70
        change-size 50

        risk (calculate-risk dependencies criticality change-size)
        tests (suggest-tests function-name)]

    (println "\n=== GAMECHANGE RADAR ===")
    (println "Promenjena funkcija:" function-name)
    (println "Ocena rizika:" risk)
    (println "Nivo rizika:" (risk-level risk))

    (println "\nPredlozeni testovi:")
    (doseq [test tests]
      (println "-" test))

    (println "\nPreporuka:")
    (println (risk-recommendation risk))))
