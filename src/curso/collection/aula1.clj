(ns curso.collection.aula1)

;["Fabio", "Lucas", "Martins", "Lima"] Vetor
;{ "Fabio" 22, "Lucas" 19}  Map
;'(1 2 3 4) Lista ligada
;#{} Conjunto

; map
; reduce
; filter

; loop
; for

(map println ["Fabio", "Lucas", "Martins", "Lima"])
(println (first ["Fabio", "Lucas", "Martins", "Lima"]))
(println (rest ["Fabio", "Lucas", "Martins", "Lima"]))
(println (rest []))
(println (next ["Fabio", "Lucas", "Martins", "Lima"]))
(println (next []))
(println (seq []))
(println (seq [1 2 3 4]))

(println "\n\nMEU MAP")

(defn meu-map
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-map funcao (rest sequencia))))))

(meu-map println ["Fabio", "Lucas", "Martins", "Lima"])
(meu-map println ["Fabio", false, "Lucas", "Martins", "Lima"])
(meu-map println [])
(meu-map println nil)


