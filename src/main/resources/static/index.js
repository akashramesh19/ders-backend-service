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

    if(searchRes.status===200)
    {
        arrayResp = await searchRes.json();
        response.innerHTML = JSON.stringify(arrayResp).replace(/[,]+/, "<br>"); 
        //const mapFormt = new Map(Object.entries(JSON.parse(arrayResp))) 
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
