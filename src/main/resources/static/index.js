const button = document.querySelector('input[type="button"]');
const path = document.getElementById("path");
const response = document.getElementById("response"); 
button.addEventListener("click", indexFiles);



const callFileIndexer = async() =>
{
    const indexRes = await fetch('/ders/index',
    {
        method: 'POST',
        body: JSON.stringify({
            path : document.getElementById("path").value
        }),
        headers: {
            'Content-Type': 'application/json'
          },
    }) ;

    
    if(indexRes.status==200)
    {
    response.innerText = "Files have been Indexed";
    console.log(indexRes);
    button.value = "Search";
    path.value = " ";
    document.getElementById("prompt").innerText = "Enter Search Term"


}
    else{
        response.innerText = "Error"
        console.log(indexRes.status);
    }
}

const callSearch = async() =>
{
    const searchRes = await fetch ('/ders/search',{
    
    method: 'POST',
    body: JSON.stringify({
        searchWords : document.getElementById("path").value
    }),
    headers: {
        'Content-Type': 'application/json'
      },

    });

    if(searchRes.ok)
    {
        arrayResp = await searchRes.json();
        response.innerHTML = "Please See the result below <br>" ;
        for(const[key,value] of Object.entries(arrayResp))
        {
            console.log(`${key}, ${value}`); 
        }
        createTable(arrayResp); 
        console.log(arrayResp);
    }
    else{
        response.innerText = "Error"
        console.log(searchRes.status);
    } 
}

function indexFiles()
{
    console.log("Files Indexer Called");
    response.innerText = "Please Wait Indexing Files"; 
    console.log(document.getElementById("path").value);

    if(button.value==="Index Files")
    {callFileIndexer();}
    else
    {callSearch();}
}


function createTable(respo)
{
    const table = document.createElement("table");
    table.setAttribute("class", "border_class");
    const headerRow = document.createElement("tr");
    const headerCell1 = document.createElement("th");
    headerCell1.textContent = "File Name";
    const headerCell2 = document.createElement("th");
    headerCell2.textContent = "Score";
    headerRow.appendChild(headerCell1);
    headerRow.appendChild(headerCell2);
    table.appendChild(headerRow);

    for (const [key, value] of Object.entries(respo)) {
        // Create a row for each key-value pair
        const row = document.createElement("tr");
        const cell1 = document.createElement("td");
        cell1.innerHTML = "<a href ="+key+">"+key+"</a>"; 
        const cell2 = document.createElement("td");
        cell2.textContent = value;
        row.appendChild(cell1);
        row.appendChild(cell2);
        table.appendChild(row);
      } 

      document.body.appendChild(table);
}
