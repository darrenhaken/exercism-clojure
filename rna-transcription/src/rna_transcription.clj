(ns rna-transcription)

(def ^:private transcriptions
  {\A \U,
   \C \G,
   \G \C,
   \T \A})

(defn- assert-valid [nucleotide]
  (assert (every? (partial contains? transcriptions) nucleotide)
          (str "Invalid RNA strand: " nucleotide)))

(defn to-rna [dna-strand]
  (assert-valid dna-strand)
  (apply str (map transcriptions dna-strand)))
