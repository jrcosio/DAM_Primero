(:Ejercicio 3: El nombre y el recorrido de los cruceros que se organizan cada mes,
con un precio base superior seiscientos euros ordenados por su nombre.:)

for $i in doc("cruceros.xml")/cruceros/crucero 
where $i/frecuencia='cada_mes' and $i/precio/base > 600
order by $i/nombre
return <crucero>{$i/nombre}{$i/recorrido}</crucero>