// Songs
function solve(array) {
    
    class Song {
        constructor(typeList, name, age) {
            this.typeList = typeList;
            this.name = name;
            this.age = age;
        }
    }

    let songs = [];
    const numberOfSongs = array.shift();
    const typeList = array.pop();
    
    for(let i = 0; i < numberOfSongs; i++) {
        const[typeList, name, time] = array[i].split('_');
        songs.push(new Song(typeList, name, time));
    }

    for (const song of songs) {
        if (typeList == 'all') {
            console.log(song.name);
        } else if (song.typeList == typeList) {
            console.log(song.name);
        }
    }
}

solve([3, "favourite_DownTown_3:14", "favourite_Kiss_4:16", "favourite_Smooth Criminal_4:01", "favourite"]);
// Expected Output:
// DownTown
// Kiss
// Smooth Criminal

solve([4, "favourite_DownTown_3:14", "listenLater_Andalouse_3:24", "favourite_In To The Night_3:58", "favourite_Live It Up_3:48", "listenLater"]);
// Expected Output:
// Andalouse

solve([2, "like_Replay_3:15", "ban_Photoshop_3:48", "all"]);
// Expected Output:
// Replay
// Photoshop
