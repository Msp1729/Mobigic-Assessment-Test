package com.metiit.mobigic.Repositery;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metiit.mobigic.Entity.File;



public interface FileRepository extends JpaRepository<File, Integer> {

	@Query("select f from File f where f.id= :id")
	public File findbyFk(@Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("UPDATE File f SET  f.nameOfFile=:i,  f.fileName=:filename WHERE f.F_Id =:id")
	public void editById( @Param("i") String nameOfFile, 
			@Param("filename") String fileName,  @Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("Delete from File f where f.F_Id=:id")
	public void deleteFile(@Param("id") Integer id);

	@Query("select f from File f where f.F_Id= :id")
	public File findByCustomId(@Param("id") Integer id);



	@Query(value = "select * from file where id=:id", nativeQuery = true)
	public List<File> fetchByFIdFile(@Param("id") int id);
}
