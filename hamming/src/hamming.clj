(ns hamming)

(defn- differences [strand1 strand2]
  (filter identity (map not= strand1 strand2)))

(defn distance [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (count (differences strand1 strand2))))
