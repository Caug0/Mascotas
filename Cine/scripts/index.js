const URL_API = "http://localhost:8080/peliculas"


async function get_peliculas () {
  // Enviar petición
  const resp = await fetch(URL_API)
  // Obtener datos de la petición
  const Peliculas = await resp.json()
  return Peliculas
}


function show (Peliculas){ 
    let card= ""
    // Iterar array
    for (let i = 0; i < Peliculas.length ; i++) {
        const obj = Peliculas[i]
        card +=`
            <article class="card">
                <div class= "body-card">
                        <h2>${obj.titulo}</h2>
                        <span>Director: ${obj.director}</span>  
                        <span>Genero: ${obj.genero}</span>
                        <span>Año estreno: ${obj.anno}</span>
                        <span>Protagonista: ${obj.protagonista}</span>
                        <span>Critica:${obj.critica}</span>
                </div>
            </article>`}
    document.getElementById('section-cards').innerHTML = card
  }


      
async function main () {
    const Peliculas = await get_peliculas()
    show(Peliculas)
    }
      
main()