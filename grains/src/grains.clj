(ns grains
  (:require [clojure.math.numeric-tower :as math]))

(defn power-of [board-square]
  (dec board-square))

(defn square [board-square]
  (math/expt 2 (power-of board-square)))

(defn total []
  (dec (square 65)))
