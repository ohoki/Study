const textObj = new String('Hello World!');
const text = 'Hello World!';
console.log(textObj);
console.log(text);
console.log(text.length);

console.log(text[0]); //배열로 접근
console.log(text.charAt(1)); //함수로 접근

console.log(text.indexOf('o')); //앞에서부터 배열
console.log(text.lastIndexOf('o')); // 뒤에서부터 배열

console.log(text.includes('h'));
console.log(text.includes('H'));

console.log(text.startsWith('He'));
console.log(text.endsWith('!'));

console.log(text.toUpperCase());
console.log(text.toLowerCase());

console.log(text.substring(0, 2)); //0부터 2번까지 (2번 포함 X)
console.log(text.slice(2));
console.log(text.slice(-2));

const space = '                   space                         '
console.log(space.trim());

const longText = 'Get to the point';
console.log(longText.split(' ')); 
console.log(longText.split(' ', 2)); 