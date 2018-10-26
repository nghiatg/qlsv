package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="HeDT")
public class System {
    @Id
    @Column(name="MaHeDT")
    private String systemId;
    @Column(name="tenHeDT")
    private String systemName;
    @OneToMany(mappedBy="system",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<TheClass> listClass;
    public void addClass(TheClass theClass) {
    	if(listClass==null) listClass=new ArrayList<>();
    	listClass.add(theClass);
    }
}
