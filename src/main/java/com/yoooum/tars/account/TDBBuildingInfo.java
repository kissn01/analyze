// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.account;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class TDBBuildingInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public TWorkPlatDb stworkplatdb = null;
	@TarsStructProperty(order = 1, isRequire = false)
	public TProduceBuildData stfarmland = null;
	@TarsStructProperty(order = 2, isRequire = false)
	public TProduceBuildData stpaddock = null;
	@TarsStructProperty(order = 3, isRequire = false)
	public TProduceBuildData storehole = null;
	@TarsStructProperty(order = 4, isRequire = false)
	public int iglobalseq = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public java.util.Map<java.lang.Integer, java.util.List<TDecoratedDb>> mdecorateddb = null;
	@TarsStructProperty(order = 6, isRequire = false)
	public TFormulationDBInfo stformulationdb = null;
	@TarsStructProperty(order = 7, isRequire = false)
	public TWharfDbInfo stwharfdb = null;
	@TarsStructProperty(order = 8, isRequire = false)
	public TBackGarden stgarden = null;
	@TarsStructProperty(order = 9, isRequire = false)
	public TExplorationDBData stexplordata = null;

	public TWorkPlatDb getStworkplatdb() {
		return stworkplatdb;
	}

	public void setStworkplatdb(TWorkPlatDb stworkplatdb) {
		this.stworkplatdb = stworkplatdb;
	}

	public TProduceBuildData getStfarmland() {
		return stfarmland;
	}

	public void setStfarmland(TProduceBuildData stfarmland) {
		this.stfarmland = stfarmland;
	}

	public TProduceBuildData getStpaddock() {
		return stpaddock;
	}

	public void setStpaddock(TProduceBuildData stpaddock) {
		this.stpaddock = stpaddock;
	}

	public TProduceBuildData getStorehole() {
		return storehole;
	}

	public void setStorehole(TProduceBuildData storehole) {
		this.storehole = storehole;
	}

	public int getIglobalseq() {
		return iglobalseq;
	}

	public void setIglobalseq(int iglobalseq) {
		this.iglobalseq = iglobalseq;
	}

	public java.util.Map<java.lang.Integer, java.util.List<TDecoratedDb>> getMdecorateddb() {
		return mdecorateddb;
	}

	public void setMdecorateddb(java.util.Map<java.lang.Integer, java.util.List<TDecoratedDb>> mdecorateddb) {
		this.mdecorateddb = mdecorateddb;
	}

	public TFormulationDBInfo getStformulationdb() {
		return stformulationdb;
	}

	public void setStformulationdb(TFormulationDBInfo stformulationdb) {
		this.stformulationdb = stformulationdb;
	}

	public TWharfDbInfo getStwharfdb() {
		return stwharfdb;
	}

	public void setStwharfdb(TWharfDbInfo stwharfdb) {
		this.stwharfdb = stwharfdb;
	}

	public TBackGarden getStgarden() {
		return stgarden;
	}

	public void setStgarden(TBackGarden stgarden) {
		this.stgarden = stgarden;
	}

	public TExplorationDBData getStexplordata() {
		return stexplordata;
	}

	public void setStexplordata(TExplorationDBData stexplordata) {
		this.stexplordata = stexplordata;
	}

	public TDBBuildingInfo() {
	}

	public TDBBuildingInfo(TWorkPlatDb stworkplatdb, TProduceBuildData stfarmland, TProduceBuildData stpaddock, TProduceBuildData storehole, int iglobalseq, java.util.Map<java.lang.Integer, java.util.List<TDecoratedDb>> mdecorateddb, TFormulationDBInfo stformulationdb, TWharfDbInfo stwharfdb, TBackGarden stgarden, TExplorationDBData stexplordata) {
		this.stworkplatdb = stworkplatdb;
		this.stfarmland = stfarmland;
		this.stpaddock = stpaddock;
		this.storehole = storehole;
		this.iglobalseq = iglobalseq;
		this.mdecorateddb = mdecorateddb;
		this.stformulationdb = stformulationdb;
		this.stwharfdb = stwharfdb;
		this.stgarden = stgarden;
		this.stexplordata = stexplordata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(stworkplatdb);
		result = prime * result + TarsUtil.hashCode(stfarmland);
		result = prime * result + TarsUtil.hashCode(stpaddock);
		result = prime * result + TarsUtil.hashCode(storehole);
		result = prime * result + TarsUtil.hashCode(iglobalseq);
		result = prime * result + TarsUtil.hashCode(mdecorateddb);
		result = prime * result + TarsUtil.hashCode(stformulationdb);
		result = prime * result + TarsUtil.hashCode(stwharfdb);
		result = prime * result + TarsUtil.hashCode(stgarden);
		result = prime * result + TarsUtil.hashCode(stexplordata);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TDBBuildingInfo)) {
			return false;
		}
		TDBBuildingInfo other = (TDBBuildingInfo) obj;
		return (
			TarsUtil.equals(stworkplatdb, other.stworkplatdb) &&
			TarsUtil.equals(stfarmland, other.stfarmland) &&
			TarsUtil.equals(stpaddock, other.stpaddock) &&
			TarsUtil.equals(storehole, other.storehole) &&
			TarsUtil.equals(iglobalseq, other.iglobalseq) &&
			TarsUtil.equals(mdecorateddb, other.mdecorateddb) &&
			TarsUtil.equals(stformulationdb, other.stformulationdb) &&
			TarsUtil.equals(stwharfdb, other.stwharfdb) &&
			TarsUtil.equals(stgarden, other.stgarden) &&
			TarsUtil.equals(stexplordata, other.stexplordata) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != stworkplatdb) {
			_os.write(stworkplatdb, 0);
		}
		if (null != stfarmland) {
			_os.write(stfarmland, 1);
		}
		if (null != stpaddock) {
			_os.write(stpaddock, 2);
		}
		if (null != storehole) {
			_os.write(storehole, 3);
		}
		_os.write(iglobalseq, 4);
		if (null != mdecorateddb) {
			_os.write(mdecorateddb, 5);
		}
		if (null != stformulationdb) {
			_os.write(stformulationdb, 6);
		}
		if (null != stwharfdb) {
			_os.write(stwharfdb, 7);
		}
		if (null != stgarden) {
			_os.write(stgarden, 8);
		}
		if (null != stexplordata) {
			_os.write(stexplordata, 9);
		}
	}

	static TWorkPlatDb cache_stworkplatdb;
	static { 
		cache_stworkplatdb = new TWorkPlatDb();
	}
	static TProduceBuildData cache_stfarmland;
	static { 
		cache_stfarmland = new TProduceBuildData();
	}
	static TProduceBuildData cache_stpaddock;
	static { 
		cache_stpaddock = new TProduceBuildData();
	}
	static TProduceBuildData cache_storehole;
	static { 
		cache_storehole = new TProduceBuildData();
	}
	static java.util.Map<java.lang.Integer, java.util.List<TDecoratedDb>> cache_mdecorateddb;
	static { 
		cache_mdecorateddb = new java.util.HashMap<java.lang.Integer, java.util.List<TDecoratedDb>>();
		int var_102 = 0;
		java.util.List<TDecoratedDb> var_103 = new java.util.ArrayList<TDecoratedDb>();
		TDecoratedDb var_104 = new TDecoratedDb();
		var_103.add(var_104);
		cache_mdecorateddb.put(var_102 ,var_103);
	}
	static TFormulationDBInfo cache_stformulationdb;
	static { 
		cache_stformulationdb = new TFormulationDBInfo();
	}
	static TWharfDbInfo cache_stwharfdb;
	static { 
		cache_stwharfdb = new TWharfDbInfo();
	}
	static TBackGarden cache_stgarden;
	static { 
		cache_stgarden = new TBackGarden();
	}
	static TExplorationDBData cache_stexplordata;
	static { 
		cache_stexplordata = new TExplorationDBData();
	}

	public void readFrom(TarsInputStream _is) {
		this.stworkplatdb = (TWorkPlatDb) _is.read(cache_stworkplatdb, 0, false);
		this.stfarmland = (TProduceBuildData) _is.read(cache_stfarmland, 1, false);
		this.stpaddock = (TProduceBuildData) _is.read(cache_stpaddock, 2, false);
		this.storehole = (TProduceBuildData) _is.read(cache_storehole, 3, false);
		this.iglobalseq = _is.read(iglobalseq, 4, false);
		this.mdecorateddb = (java.util.Map<java.lang.Integer, java.util.List<TDecoratedDb>>) _is.read(cache_mdecorateddb, 5, false);
		this.stformulationdb = (TFormulationDBInfo) _is.read(cache_stformulationdb, 6, false);
		this.stwharfdb = (TWharfDbInfo) _is.read(cache_stwharfdb, 7, false);
		this.stgarden = (TBackGarden) _is.read(cache_stgarden, 8, false);
		this.stexplordata = (TExplorationDBData) _is.read(cache_stexplordata, 9, false);
	}

}
