var balance = {$toDouble: "$credit.balance"}
db.people.aggregate([
    {$match: {sex: "Female", nationality: "Poland"}},
    {$unwind: {path: "$credit"}},
    {$group: {
        _id: "$credit.currency",
        total_balance: {"$sum": balance},
        avg_balance: {"$avg": balance}}}
])
