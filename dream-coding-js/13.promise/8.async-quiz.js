function fetchEgg(chicken) {
  return Promise.resolve(`${chicken} => 🥚`);
}

function fryEgg(egg) {
  return Promise.resolve(`${egg} => 🍳`);
}

function getChicken() {
  return Promise.resolve(`🌱 => 🐔`);
}

async function getFriedEgg() {
  const chicken = await getChicken();
  const egg = await fetchEgg(chicken);
  const fryegg = await fryEgg(egg);
  return fryegg;
}

getFriedEgg()
  .then ((friedEgg) => console.log(friedEgg));


/**
 * async function getFriedEgg() {
 *  let chicken;
 *    try {
 *      chicken = await getChicken();
 *    } catch {
 *        chicken = '🐔';
 *    }
      const egg = await fetchEgg(chicken);
      return fryEgg(egg);
}

getFriedEgg().then (console.log);
 */