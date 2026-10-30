(ns balance-algorithm.core)

(defn calculate-risk [dependencies criticality change-size]
  (+ (* dependencies 0.4)
     (* criticality 0.4)
     (* change-size 0.2)))

(defn risk-level [risk]
  (cond
    (< risk 30) "Low"
    (< risk 60) "Medium"
    :else "High"))

(defn suggest-tests [function-name]
  (cond
    (= function-name "move_enemy")
    ["Check enemy speed"
     "Check collisions with walls"
     "Check movement around obstacles"]

    (= function-name "attack_player")
    ["Check enemy attacks"
     "Check player health reduction"]

    (= function-name "spawn_wave")
    ["Check enemy spawning"
     "Check wave completion"]

    :else
    ["Manually test the changed function"]))

(defn risk-recommendation [risk]
  (cond
    (< risk 30) "Basic testing is sufficient."
    (< risk 60) "Additional testing is recommended."
    :else "Thorough testing is required!"))

(defn -main []
  (let [function-name "move_enemy"
        dependencies 80
        criticality 70
        change-size 50

        risk (calculate-risk dependencies criticality change-size)
        tests (suggest-tests function-name)]

    (println "\n=== GAMECHANGE RADAR ===")
    (println "Changed function:" function-name)
    (println "Risk score:" risk)
    (println "Risk level:" (risk-level risk))

    (println "\nSuggested tests:")
    (doseq [test tests]
      (println "-" test))

    (println "\nRecommendation:")
    (println (risk-recommendation risk))))
