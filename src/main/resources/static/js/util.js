$("span.url-text").each(function(index){
    try {
        let url = new URL(this.innerText);
        this.innerText = url.hostname;
    } catch(e){
        this.innerText = "";
    }
})