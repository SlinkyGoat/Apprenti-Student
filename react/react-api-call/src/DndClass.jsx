import './DndClass.css';

export default function DndClass({ data }){

    if (!data) return null;
    let proficiencies = data.proficiencies;
    let displayProficiencies = proficiencies
        .filter(p => !p.index.startsWith("saving"))
        .map(p => p.name)
        .join(", ");

    let subclasses = data.subclasses;
    let displaySubclasses = subclasses.map(s => s.name).join(", ");

    return (
        <div className="class-grid">
            <div className="row">
                <div className="label">Class Name:</div>
                <div className="value">{data.name}</div>
            </div>
            <div className="row">
                <div className="label">Hit Die:</div>
                <div className="value">{data.hit_die}</div>
            </div>
            <div className="row">
                <div className="label">Proficiencies:</div>
                <div className="value">{displayProficiencies}</div>
            </div>
            <div className="row">
                <div className="label">Saving Throws:</div>
                <div className="value">{data.saving_throws[0].name} & {data.saving_throws[1].name}</div>
            </div>
            <div className="row">
                <div className="label">Subclasses:</div>
                <div className="value">{displaySubclasses}</div>
            </div>
        </div>
    );
}