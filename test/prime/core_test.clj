(ns prime.core-test
  (:require [clojure.test :refer :all]
            [prime.core :refer :all]))

(deftest prime-test
  (testing "function returns if n is prime"
    (is (= true (is-prime? 2)))
    (is (= false (is-prime? 6)))))
