class Organization {
    #name;
    #country;
    constructor(name, country) {
        this.#name = name;
        this.#country = country;
    }

    get name() {
        return this.#name;
    }

    get country() {
        return this.#country;
    }
}

const organization = new Organization('Acme Gooseberries', 'GB');

// organization.name = 'Dream Coding';
console.log(organization.name);
console.log(organization.country);
