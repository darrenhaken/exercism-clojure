(ns trinary
  (:require [clojure.math.numeric-tower :as math]))

(defn trinary-char->int [trinary-char]
  (cond
    (= trinary-char \0) 0
    (= trinary-char \1) 1
    (= trinary-char \2) 2))

(defn trinary->decimal [shift trinary]
  (* trinary (math/expt 3 shift)))

(defn process-vector [trinary]
  (->> trinary
       (map trinary-char->int)
       reverse
       (map-indexed trinary->decimal)
       (reduce +)))

(defn to-decimal [trinary]
  (if (re-matches #"[0-2]+" trinary)
    (process-vector trinary)
    0))
