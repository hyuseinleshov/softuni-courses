function solve(text) {
    const words = text.match(/\w+/g).map(word => word.toUpperCase());
    console.log(words.join(', '));
}

solve('Hi, how are you?');	// HI, HOW, ARE, YOU
solve('hello');             // HELLO