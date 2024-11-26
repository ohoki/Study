//컴포지션(위임)
class Printer {
    #printerHeader;
    constructor(printerHeader) {
        this.#printerHeader = printerHeader;
    }

    print() {
        this.#printerHeader
            ? this.#printerHeader.print()
            : console.log('기본적인 출력');
    }
}

class RedPrinter {
    print() {
        console.log('🔴 출력!');
    }
}

class BlackPrinter {
    print() {
        console.log('⚫️ 출력!');
    }
}

const printers = [
    new Printer(), 
    new RedPrinter(new RedPrinter()),
    new RedPrinter(new BlackPrinter())
];

printers.forEach((printer) => printer.print());