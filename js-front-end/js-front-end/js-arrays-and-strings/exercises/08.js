// Pascal-Case Splitter
function solve(text) {
    console.log(text.split(/(?=[A-Z])/).join(", "));
}

solve('SplitMeIfYouCanHaHaYouCantOrYouCan'); 
// Output: Split, Me, If, You, Can, Ha, Ha, You, Cant, Or, You, Can

solve('HoldTheDoor'); 
// Output: Hold, The, Door

solve('ThisIsSoAnnoyingToDo'); 
// Output: This, Is, So, Annoying, To, Do