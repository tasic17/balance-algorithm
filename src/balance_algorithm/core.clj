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

;; Predlog testova na osnovu promenjene funkcije
(defn suggest-test [function-name]
  (cond
    (= function-name "move_enemy")
    "Testirati kretanje neprijatelja"

    (= function-name "attack_player")
    "Testirati napad i zdravlje igraca"

    (= function-name "spawn_wave")
    "Testirati pojavljivanje neprijatelja"

    :else "Rucno proveriti funkciju"))

;; Glavni program
(defn -main []
  (let [function-name "move_enemy"
        dependencies 80
        criticality 70
        change-size 50

        risk (calculate-risk dependencies criticality change-size)]

    (println "=== GAMECHANGE RADAR ===")
    (println "Promenjena funkcija:" function-name)
    (println "Ocena rizika:" risk)
    (println "Nivo rizika:" (risk-level risk))
    (println "Predlozeni test:" (suggest-test function-name))))