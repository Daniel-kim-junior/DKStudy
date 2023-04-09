import { MongoClient } from "mongodb";

// Replace the uri string with your MongoDB deployment's connection string.
const uri = "mongodb://127.0.0.1";

const client = new MongoClient(uri);

async function run() {
  try {
    const database = client.db("hr");
    const emps = database.collection("emps");

    // Query for a movie that has the title 'The Room'
    const query = { age: {$lt: 40} };

    const options = {
      // sort matched documents in descending order by rating
      sort: { title: 1 },
      // Include only the `title` and `imdb` fields in the returned document
      projection: { _id: 0, title: 1, imdb: 1 },
    };

    // const emp = await emps.findOne(query, options);
    const emp = emps.find(query);

    if(( await emps.countDocuments(query)) === 0){
      console.log('No');
    }
    
    await emp.forEach(console.dir);

    // since this method returns the matched document, not a cursor, print it directly
  } finally {
    await client.close();
  }
}
run().catch(console.dir);
