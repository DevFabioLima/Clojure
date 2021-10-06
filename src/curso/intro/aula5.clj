(ns curso.aula5)

(def estoque {"Mochila" 10, "Camiseta" 5})
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves são" (keys estoque))
(println "Valores são" (vals estoque))

; Keywords

(def estoque {:mochila 10, :camiseta 5})
(println estoque)

(println (assoc estoque :cadeira 32))
(println estoque)

(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "tirando um de" valor)
  (- valor 1))

(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))

(println (dissoc estoque :mochila))

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println "\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)
(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira {}))                          ; map com valor default
(println (:mochila pedido))                                 ; mais comum

(println (:quantidade (:mochila pedido)))

(println (:quantidade (:mochila pedido)))                   ; menos utilizada

; THREADING FIRST
(println pedido)
(println (-> pedido
             ,, :mochila                                       ; Mais utilizada
             ,, :quantidade))











