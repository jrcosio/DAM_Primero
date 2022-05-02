(:Ejercicio 5: El nombre del crucero, el del puerto de salida y el precio de un camarote exterior
(que se calcula añadiendo al precio base, el precio extra por un camarote exterior) de aquellos 
cruceros que paran o salen de la ciudad de Bari:)

for $i in doc("cruceros.xml")/cruceros/crucero 
where $i/recorrido/puerto_salida='Bari' or $i/recorrido/etapa/puerto='Bari'
return <crucero>
                {$i/nombre}{$i/recorrido/puerto_salida}
                <precio_en_camarote_exterior>{$i/precio/extra_camarote_exterior + $i/precio/base}</precio_en_camarote_exterior>
       </crucero>