(ns prime-factors)

(defn- no-remainder? [number candidate]
  (zero? (rem number candidate)))

(defn of
  ([number]
   (of number 2 []))
  ([number primeCandidate accumulator]
   (cond
     (<= number 1) accumulator
     (no-remainder? number primeCandidate) (recur (/ number primeCandidate) primeCandidate (conj accumulator primeCandidate))
     :else (recur number (inc primeCandidate) accumulator))))
