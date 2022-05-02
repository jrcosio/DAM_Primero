(:Ejercicio 4: El nombre y el número de etapas de los cruceros que se organizan “cada_dos_meses”:)

for $i in doc("cruceros.xml")/cruceros/crucero 
where $i/frecuencia='cada_dos_meses'
let $num :=  $i/recorrido/etapa 
return <crucero>{$i/nombre}<numero_de_etapas>{count($num)}</numero_de_etapas></crucero>