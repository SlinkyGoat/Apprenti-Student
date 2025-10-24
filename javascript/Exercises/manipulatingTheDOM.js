function changeBackgroundColor(){
    let red = Math.floor(Math.random() * 256);
    let green = Math.floor(Math.random() * 256);
    let blue = Math.floor(Math.random() * 256);
    document.body.style.backgroundColor = `rgb(${red}, ${blue}, ${green})`;
}


function addItemToList(){
    let randomStuff = ["Artificer", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger",
        "Warlock", "Wizard", "Elf", "Gnome", "Dwarf", "Dragonborn", "Giant", "Orc", "Hobgoblin", "Mindflayer", "Mimic",
        "Bugbear", "Doppelganger", "Dragon", "Giant Spider", "Gibbering Mouther", "Gnoll"
    ]
    let listToAddTo = document.getElementById("addItems");
    let li = document.createElement("li");
    li.textContent = randomStuff[Math.floor(Math.random() * randomStuff.length)];
    listToAddTo.appendChild(li);
}



document.getElementById("changeColorBtn").addEventListener("click", changeBackgroundColor);
document.getElementById("addItemBtn").addEventListener("click", addItemToList);
