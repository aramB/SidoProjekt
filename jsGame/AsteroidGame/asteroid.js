var game = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = 1280;
        this.canvas.height =720;
        // context lets us draw on canvas
        this.ctx = this.canvas.getContext("2d");
        document.body.appendChild(this.canvas);
        // creates interval, calls update() every 1ms
        this.interval = setInterval(update, 1);
    },
    clear : function() {
        this.ctx.reactRect(0, 0, this.canvas.width, this.canvas.height);
        this.ctx.fillStyle = "black";
        this.ctx.fillRect(0, 0, this.canvas.width, this.canvas.height);
    }     
};



