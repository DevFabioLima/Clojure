(ns curso.collection.aula4
  (:require
    [curso.collection.db :as c.db]
    [curso.collection.logic :as c.logic]))

(println (c.logic/resumo-por-usuario (c.db/todos-os-pedidos)))

(let [pedidos (c.db/todos-os-pedidos)
      resumo (c.logic/resumo-por-usuario (c.db/todos-os-pedidos))]
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado ao contrário" (reverse (sort-by :preco-total resumo)))

  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       c.logic/resumo-por-usuario
       (sort-by :preco-total)))


(let [pedidos (c.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
      (println "Resumo" resumo)
      (println "Primeiro" (first resumo))
      (println "Segundo" (second resumo))
      (println "Resto" (rest resumo))
      (println "Total" (count resumo))
      (println "Class" (class resumo))
      (println "nth 5" (nth resumo 3)))


(let [pedidos (c.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "todos > 500" (filter #(> (:preco-total %) 500) resumo))
  (println "alguém é > 500? " (some #(> (:preco-total %) 500) resumo)))

