interface User {
    id: number;
    name: string;
    age: number;
    gender: string;
    badges: string[];
    additionalInfo?: string;
}

const REPO: User[] = [
    {
        id: 1,
        name: 'John',
        age: 25,
        gender: 'Male',
        badges: ['Gold', 'Silver'],
        additionalInfo: '',
    },
    {
        id: 2,
        name: 'Jane',
        age: 30,
        gender: 'Female',
        badges: ['Platinum'],
        additionalInfo: '',
    },
    {
        id: 3,
        name: 'Bob',
        age: 22,
        gender: 'Male',
        badges: ['Bronze'],
        additionalInfo: '',
    },
    {
        id: 4,
        name: 'Alice',
        age: 28,
        gender: 'Female',
        badges: ['Gold'],
        additionalInfo: '',
    },
    {
        id: 5,
        name: 'Charlie',
        age: 35,
        gender: 'Male',
        badges: ['Silver', 'Bronze'],
        additionalInfo: '',
    },
    {
        id: 6,
        name: 'Diana',
        age: 26,
        gender: 'Female',
        badges: ['Gold', 'Platinum'],
        additionalInfo: '',
    },
    {
        id: 7,
        name: 'Edward',
        age: 40,
        gender: 'Male',
        badges: [],
        additionalInfo: '',
    },
    {
        id: 8,
        name: 'Fiona',
        age: 32,
        gender: 'Female',
        badges: ['Silver'],
        additionalInfo: '',
    },
    {
        id: 9,
        name: 'George',
        age: 19,
        gender: 'Male',
        badges: ['Bronze'],
        additionalInfo: '',
    },
    {
        id: 10,
        name: 'Hannah',
        age: 24,
        gender: 'Female',
        badges: ['Gold'],
        additionalInfo: '',
    },
];

console.log("Hello, TypeScript!");

console.log(REPO);

const goldOwners = REPO
    .filter(person => person.badges.includes('Gold'))
    .map(person => {
        return {
            ...person,
            additionalInfo: 'Gold Badge Holder'
        };
    });
console.log(goldOwners);
