function Fetch(){
    fetch("http://localhost:8080/flights_api/City")
    .then(response => response.json())
    .then(data => showData(data))
}

function showData(data){
    console.log(data);
}

Fetch();