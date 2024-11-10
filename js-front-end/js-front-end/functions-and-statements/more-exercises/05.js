// Print DNA
function solve(length) {
    const sequence = "ATCGTTAGGG";
    let index = 0;

    for (let i = 0; i < length; i++) {
        let part = sequence[index % sequence.length] + sequence[(index + 1) % sequence.length];
        index += 2;

        if (i % 4 === 0) {
            console.log(`**${part}**`);
        } else if (i % 4 === 1) {
            console.log(`*${part[0]}--${part[1]}*`);
        } else if (i % 4 === 2) {
            console.log(`${part[0]}----${part[1]}`);
        } else if (i % 4 === 3) {
            console.log(`*${part[0]}--${part[1]}*`);
        }
    }
}

solve(4);
// **AT**
// *C--G*
// T----T
// *A--G*
solve(10);
// **AT**
// *C--G*
// T----T
// *A--G*
// **GG**
// *A--T*
// C----G
// *T--T*
// **AG**
// *G--G*