db.people.insertOne(
    {
        birth_date: "1995-09-18T00:00:00Z",
        credit: [{"type": "jcb", "number": "123", currency: "PLN", balance: 0}],
        description: "description",
        email: "s23684@pjwstk.edu.pl",
        first_name: "Rufin",
        last_name: "Latawiec",
        height: "183",
        job: "student",
        location: {address: "Street 1", city: "Warsaw"},
        nationality: "Poland",
        sex: "Male",
        weight: "78"
    }
);

