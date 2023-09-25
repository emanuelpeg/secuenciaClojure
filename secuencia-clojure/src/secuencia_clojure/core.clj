(ns secuencia-clojure.core
  (:gen-class))

(import '(java.util Scanner))
(def scan (Scanner. *in*))

   
(defn generateSecEven []
  (def seed (rand-int 30))
  (for [x (range seed (+ seed 4))] (* x 2))
)
   
(defn generateSecOdd []
  (def seed (rand-int 30))
  (for [x (range seed (+ seed 4))] (+ (* x 2) 1))
)

(defn generateSecFibo []
  (def seed (rand-int 30))
  (def seed2 (* seed 2))
  (def seed3 (* seed 3))
  (list seed seed seed2 seed3)
)

(defn generateSec []
  (def seed (rand-int 3))
  (cond 
    (= seed 0) (generateSecEven)
    (= seed 1) (generateSecOdd)
    (= seed 2) (generateSecFibo)   
  )
)

(defn printSec [sec]
  (print (nth sec 0))
  (print " ")
  (print (nth sec 1))
  (print " ")
  (print " __ ")
  (print " ")
  (println (nth sec 3))
)

(defn game
  [points]
  (def sec (generateSec))
  (def sol (nth sec 2))
  
  (printSec sec)
  
  (let [data (read-line)]
  (if (= data (str sol))
    (do 
      (println "Correct!! the point is " (str (+ points 1)))
      (game (+ points 1))
    )
    (do 
      (println "Wrong!! the point is " (str (- points 1)))
      (game (- points 1))
    )))
)


(defn -main
  [& args]
  (game 0))