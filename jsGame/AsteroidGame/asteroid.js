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
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
        this.ctx.fillStyle = "black";
        this.ctx.fillRect(0, 0, this.canvas.width, this.canvas.height);
    }     
};

game.start();

function character(x, y, width, height, color) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.color = color;

    this.update = function () {
        game.ctx.fillStyle = this.color;
        game.ctx.fillRect(this.x,  this.y,  this.width, this.height);
    }
}

var direction = 0;
window.addEventListener("keydown", function (ev) {
    // A = 65; D = 68; SPACE = 32
    if (ev.keyCode === 65){
        direction = -1;
    }

    if (ev.keyCode === 68){
        direction = 1;
    }
});

player = new character(game.canvas.width/2 - 30, game.canvas.height - 100, 60, 10, "red");

function update() {
    game.clear();
    player.x += direction;
    player.update();
}

