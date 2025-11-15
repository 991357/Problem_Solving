const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split(/\s+/).map(Number);

let result = [];
for (let i = 0; i < input.length; i += 2) {
    const N = input[i];
    const S = input[i + 1];
    if (N === undefined || S === undefined) break;
    result.push(Math.floor(S / (N + 1)));
}

console.log(result.join("\n"));
