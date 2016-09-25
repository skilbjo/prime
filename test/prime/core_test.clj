(ns prime.core-test
  (:require [clojure.test :refer :all]
            [prime.core :refer :all]))

(deftest prime-test
  (testing "function returns if n is prime"
    (is (= true
           (is-prime? 2)))
    (is (= false
           (is-prime? 6)))))

(deftest shape-test
  (testing "creates a vector"
    (is (= [0 0 0]
           (create-shape 3)))
    (is (= [0 0 0 0 0 0]
           (create-shape 6)))))

(deftest index-shape-test
  (testing "creates a vector of primes"
    (is (= [0 1 2 3 4]
           (create-shape-index 5)))))

(deftest primes-shape-test
  (testing "creates a vector of primes"
    (is (= [2 3 5 7 11]
           (primes-vector 5)))))

(deftest answer-test
  (testing "a 2d array of indices and primes"
    (is (= [[0 1 2] [2 3 5]]
           (answer 3)))))
