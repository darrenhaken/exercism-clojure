(ns prime-factors)

;(defn- process-candidate [number candidate]
;  (let primes [] (recur (/ number candidate) candidate (conj primes candidate))
;  )

(defn- no-remainder? [number candidate]
  (zero? (rem number candidate)))

(defn of
  ([number]
   (of number 2 []))
  ([number candidate primes]
   (cond
     (<= number 1) primes
     (no-remainder? number candidate) (recur (/ number candidate) candidate (conj primes candidate))
     :else (recur number (inc candidate) primes))))
