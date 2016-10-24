(ns word-count
  (:gen-class)
  (:require [clojure.string :as str]))

(defn- words [sentance]
  (->> sentance
       (str/lower-case)
       (re-seq #"\w+")))

(defn word-count [sentance]
  (frequencies (words sentance)))
