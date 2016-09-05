(ns prime.core
  (:gen-class))

(defn parse-int  [s]
    (Integer.  (re-find #"[0-9]*" s)))

(defn seq-contains? [coll target] 
  (if (some #(= target %) coll ) true false))

(defn sieve [s]
  (cons (first s)
        (lazy-seq (sieve (filter #(not= 0 (mod % (first s)))
                                 (rest s))))))

(defn is-prime? [n]
  (seq-contains? 
  (take n (sieve (iterate inc 2))) n))

(defn -main
  [& args]
  (if (first args)
    (println (is-prime? (parse-int (first args)))) 
    (println "Usage: provide a number to check if prime")))
