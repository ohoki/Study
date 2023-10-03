// 옵셔널 체이닝 연산자 Optional Chaining Operator
// ?.
let item ={ price: 1};
const price = item?.price;   //item && item.price;
console.log(price);

let obj = { name: '멍멍이', owner: { name: '영호'}};
function printName (obj1) {
  const ownerName = obj?.owner?.name ; //obj && obj.owner && obj.owner.name ;
  console.log(ownerName);
};
printName(obj);

