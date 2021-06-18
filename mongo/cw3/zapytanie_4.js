var weight = {$toDouble: "$weight"}
db.people.find({
    $and: [
        {$expr: {$gte: [weight, 68]}},
        {$expr: {$lt: [weight, 71.5]}}
    ]
})
