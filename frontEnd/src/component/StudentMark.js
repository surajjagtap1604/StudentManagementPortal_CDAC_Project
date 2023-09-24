import React from "react";
class StudentMark extends React.Component
{
    render()
    {
        return(
            <div className="component-b">
                <h2>In Student Mark Component</h2>
                <div className="flexbox-container">
                <div className="flexbox-item">
                    <h2>Div 1</h2>
                    <p>This is div 1.</p>
                    </div>
                    {/* Add more divs here */}
                </div>
            </div>
        )
    }
}
export default StudentMark;