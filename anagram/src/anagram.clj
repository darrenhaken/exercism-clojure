(ns anagram
  (:gen-class)
  (:require [clojure.string :as str]))

(defn- same-letters? [word other-word]
  (= (sort word) (sort other-word)))

(defn anagram? [word anagram]
  (let [word (str/lower-case word) anagram (str/lower-case anagram)]
    (and (not= word anagram)
         (same-letters? word anagram))))

(defn anagrams-for [word potential-anagrams]
  (filter (partial anagram? word) potential-anagrams))
