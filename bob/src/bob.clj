(ns bob
  (:gen-class)
  (:require [clojure.string :as str]))

(defn- silence? [phrase]
  (str/blank? (str/trim phrase)))

(defn- shouting? [phrase]
  (and
    (re-find #"[A-Z]" phrase)
    (= (str/upper-case phrase) phrase)))

(defn- question? [phrase]
  (str/ends-with? phrase "?"))

(defn response-for [phrase]
  (cond
    (silence? phrase) "Fine. Be that way!"
    (shouting? phrase) "Whoa, chill out!"
    (question? phrase) "Sure."
    :else "Whatever."))

