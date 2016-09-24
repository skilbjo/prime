(ns prime.core
  (:gen-class))

(defn parse-int  [s]
  (Integer.  (re-find #"[0-9]*" s)))

(defn seq-contains? [coll target]
  (if (some #(= target %) coll) true false))

(defn sieve [s]
  (cons (first s)
        (lazy-seq (sieve (filter #(not= 0 (mod % (first s)))
                                 (rest s))))))

(defn is-prime? [n]
  (seq-contains?
   (take n (sieve (iterate inc 2))) n))

(defn create-shape
  ([n] (create-shape (dec n) [0]))
  ([n acc] (if (= n 0) acc
               (recur (dec n) (conj acc 0)))))

(defn make-array-prime [initial-value f length]
  (loop [result (transient []), length-left length, interim-value initial-value]
    (if (= length-left 0)
      (persistent! result)
      (recur (conj! result (f interim-value)) (- length-left 1) (f interim-value)))))

(defn -main
  [& args]
  (if (first args)
    (println (create-shape (parse-int (first args))))
    (println "Usage: provide a number to check if prime")))
