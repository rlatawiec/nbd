var height = {$toDouble: "$height"}
db.people.deleteMany(
    {$expr: {$gt: [height, 190]}}
)

