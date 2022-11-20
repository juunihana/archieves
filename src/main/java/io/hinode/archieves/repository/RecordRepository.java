package io.hinode.archieves.repository;

import io.hinode.archieves.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, String> {

//    private List<RecordEntity> records;
//
//    public ArchiveRepository() {
//        records = new ArrayList<>();
//        records.add(new RecordEntity(
//                UUID.randomUUID().toString(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                "First record",
//                "This is the first record in archive. Perhaps nothing interesting here now, but I assume there " +
//                        "is going to be something greater in future."
//        ));
//
//        records.add(new RecordEntity(
//                UUID.randomUUID().toString(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                "Second record",
//                "Now there is another one record here. Still nothing much to see. What did you expect, it is a " +
//                        "personal project made for fun!"
//        ));
//
//        records.add(new RecordEntity(
//                UUID.randomUUID().toString(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                "Need. Money.",
//                "Perhaps I need more investments to develop this into something that makes any profit aside from" +
//                        "sharpening my skill in web development."
//        ));
//    }
//
//    public List<RecordEntity> getAllRecords() {
//        return records;
//    }
//
//    public RecordEntity getRecordById(String id) {
//        for (RecordEntity r : records) {
//            if (r.getId().equals(id)) {
//                return r;
//            }
//        }
//
//        return null;
//    }
//
//    public void updateRecord(String recordId, RecordEntity record) throws NoRecordFoundException {
//        RecordEntity entity = getRecordById(recordId);
//
//        if (entity != null) {
//            int index = 0;
//            for (RecordEntity r : records) {
//                if (r.getId().equals(recordId)) {
//                    entity = r;
//                    break;
//                }
//                index++;
//            }
//
//            entity.setEditTimestamp(record.getEditTimestamp());
//            entity.setTitle(record.getTitle());
//            entity.setData(record.getData());
//
//            records.remove(index);
//            records.add(index, entity);
//        } else {
//            throw new NoRecordFoundException();
//        }
//    }
}
