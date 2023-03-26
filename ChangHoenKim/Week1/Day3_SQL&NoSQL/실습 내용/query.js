// 부서별로 50살 이상의 직원이 몇명인지 출력함

db.emps.aggregate([
    {$match:{age:{$gte:50}}},
    {$group:{_id:"$dept_id", count:{"$sum":1}}}
]);

db.persons.explain("executionStats").find({"dob.age":21});
// {

//         "explainVersion" : "1",
//         "queryPlanner" : {
//                 "namespace" : "hr.persons",
//                 "indexFilterSet" : false,
//                 "parsedQuery" : {
//                         "dob.age" : {
//                                 "$eq" : 21
//                         }
//                 },
//                 "maxIndexedOrSolutionsReached" : false,
//                 "maxIndexedAndSolutionsReached" : false,
//                 "maxScansToExplodeReached" : false,
//                 "winningPlan" : {
//                         "stage" : "COLLSCAN",
//                         "filter" : {
//                                 "dob.age" : {
//                                         "$eq" : 21
//                                 }
//                         },
//                         "direction" : "forward"
//                 },
//                 "rejectedPlans" : [ ]
//         },
//         "executionStats" : {
//                 "executionSuccess" : true,
//                 "nReturned" : 76,
//                 "executionTimeMillis" : 5,
//                 "totalKeysExamined" : 0,
//                 "totalDocsExamined" : 5000,
//                 "executionStages" : {
//                         "stage" : "COLLSCAN",
//                         "filter" : {
//                                 "dob.age" : {
//                                         "$eq" : 21
//                                 }
//                         },
//                         "nReturned" : 76,
//                         "executionTimeMillisEstimate" : 0,
//                         "works" : 5002,
//                         "advanced" : 76,
//                         "needTime" : 4925,
//                         "needYield" : 0,
//                         "saveState" : 5,
//                         "restoreState" : 5,
//                         "isEOF" : 1,
//                         "direction" : "forward",
//                         "docsExamined" : 5000
//                 }
//         },
//         "command" : {
//                 "find" : "persons",
//                 "filter" : {
//                         "dob.age" : 21
//                 },
//                 "$db" : "hr"
//         },
//         "serverInfo" : {
//                 "host" : "DESKTOP-TH36TT5",
//                 "port" : 27017,
//                 "version" : "5.0.15",
//                 "gitVersion" : "935639beed3d0c19c2551c93854b831107c0b118"
//         },
//         "serverParameters" : {
//                 "internalQueryFacetBufferSizeBytes" : 104857600,
//                 "internalQueryFacetMaxOutputDocSizeBytes" : 104857600,
//                 "internalLookupStageIntermediateDocumentMaxSizeBytes" : 104857600,
//                 "internalDocumentSourceGroupMaxMemoryBytes" : 104857600,
//                 "internalQueryMaxBlockingSortMemoryUsageBytes" : 104857600,
//                 "internalQueryProhibitBlockingMergeOnMongoS" : 0,
//                 "internalQueryMaxAddToSetBytes" : 104857600,
//                 "internalDocumentSourceSetWindowFieldsMaxMemoryBytes" : 104857600
//         },
//         "ok" : 1
// }

// find의 결과가 "docsExamined" : 500개를 탐색했다는 것을 의미합니다.

db.persons.createIndex({"dob.age":1});

// {
//         "numIndexesBefore" : 1,
//         "numIndexesAfter" : 2,
//         "createdCollectionAutomatically" : false,
//         "ok" : 1
// }

// 인덱스를 생성하고 결과를 확인합니다.

db.persons.getIndexes();

// [
//         {
//                 "v" : 2,
//                 "key" : {
//                         "_id" : 1
//                 },
//                 "name" : "_id_"
//         },
//         {
//                 "v" : 2,
//                 "key" : {
//                         "dob.age" : 1
//                 },
//                 "name" : "dob.age_1"
//         }
// ]


db.persons.explain("executionStats").find({"dob.age":21});

// {
//         "explainVersion" : "1",
//         "queryPlanner" : {
//                 "namespace" : "hr.persons",
//                 "indexFilterSet" : false,
//                 "parsedQuery" : {
//                         "dob.age" : {
//                                 "$eq" : 21
//                         }
//                 },
//                 "maxIndexedOrSolutionsReached" : false,
//                 "maxIndexedAndSolutionsReached" : false,
//                 "maxScansToExplodeReached" : false,
//                 "winningPlan" : {
//                         "stage" : "FETCH",
//                         "inputStage" : {
//                                 "stage" : "IXSCAN",
//                                 "keyPattern" : {
//                                         "dob.age" : 1
//                                 },
//                                 "indexName" : "dob.age_1",
//                                 "isMultiKey" : false,
//                                 "multiKeyPaths" : {
//                                         "dob.age" : [ ]
//                                 },
//                                 "isUnique" : false,
//                                 "isSparse" : false,
//                                 "isPartial" : false,
//                                 "indexVersion" : 2,
//                                 "direction" : "forward",
//                                 "indexBounds" : {
//                                         "dob.age" : [
//                                                 "[21.0, 21.0]"
//                                         ]
//                                 }
//                         }
//                 },
//                 "rejectedPlans" : [ ]
//         },
//         "executionStats" : {
//                 "executionSuccess" : true,
//                 "nReturned" : 76,
//                 "executionTimeMillis" : 12,
//                 "totalKeysExamined" : 76,
//                 "totalDocsExamined" : 76,
//                 "executionStages" : {
//                         "stage" : "FETCH",
//                         "nReturned" : 76,
//                         "executionTimeMillisEstimate" : 10,
//                         "works" : 77,
//                         "advanced" : 76,
//                         "needTime" : 0,
//                         "needYield" : 0,
//                         "saveState" : 0,
//                         "restoreState" : 0,
//                         "isEOF" : 1,
//                         "docsExamined" : 76,
//                         "alreadyHasObj" : 0,
//                         "inputStage" : {
//                                 "stage" : "IXSCAN",
//                                 "nReturned" : 76,
//                                 "executionTimeMillisEstimate" : 10,
//                                 "works" : 77,
//                                 "advanced" : 76,
//                                 "needTime" : 0,
//                                 "needYield" : 0,
//                                 "saveState" : 0,
//                                 "restoreState" : 0,
//                                 "isEOF" : 1,
//                                 "keyPattern" : {
//                                         "dob.age" : 1
//                                 },
//                                 "indexName" : "dob.age_1",
//                                 "isMultiKey" : false,
//                                 "multiKeyPaths" : {
//                                         "dob.age" : [ ]
//                                 },
//                                 "isUnique" : false,
//                                 "isSparse" : false,
//                                 "isPartial" : false,
//                                 "indexVersion" : 2,
//                                 "direction" : "forward",
//                                 "indexBounds" : {
//                                         "dob.age" : [
//                                                 "[21.0, 21.0]"
//                                         ]
//                                 },
//                                 "keysExamined" : 76,
//                                 "seeks" : 1,
//                                 "dupsTested" : 0,
//                                 "dupsDropped" : 0
//                         }
//                 }
//         },
//         "command" : {
//                 "find" : "persons",
//                 "filter" : {
//                         "dob.age" : 21
//                 },
//                 "$db" : "hr"
//         },
//         "serverInfo" : {
//                 "host" : "DESKTOP-TH36TT5",
//                 "port" : 27017,
//                 "version" : "5.0.15",
//                 "gitVersion" : "935639beed3d0c19c2551c93854b831107c0b118"
//         },
//         "serverParameters" : {
//                 "internalQueryFacetBufferSizeBytes" : 104857600,
//                 "internalQueryFacetMaxOutputDocSizeBytes" : 104857600,
//                 "internalLookupStageIntermediateDocumentMaxSizeBytes" : 104857600,
//                 "internalDocumentSourceGroupMaxMemoryBytes" : 104857600,
//                 "internalQueryMaxBlockingSortMemoryUsageBytes" : 104857600,
//                 "internalQueryProhibitBlockingMergeOnMongoS" : 0,
//                 "internalQueryMaxAddToSetBytes" : 104857600,
//                 "internalDocumentSourceSetWindowFieldsMaxMemoryBytes" : 104857600
//         },
//         "ok" : 1
// }

// 인덱스 생성 후 "docsExamined" : 76으로 줄어든 것을 확인할 수 있습니다.