<p>TimerView is a library that allows you to add a graphic timer in your android apps, either you want a forward or backward timer, just&nbsp;add the element in your layout and start the timer.</p>

<p>&nbsp;</p>
<img alt="banner" data-align="center" data-entity-type="file" data-entity-uuid="ca53e75c-b7e9-4974-870b-25689fc58a44" src="/sites/default/files/inline-images/banner_0.png" />
<h2>Installation.</h2>

<p>The first step is to add jitpack as repository in your project, open your root <strong>build.gradle</strong> file and add the following line in <strong>repositories</strong> section:</p>

<pre>
<code>repositories {
    ...
	maven { url 'https://jitpack.io' }
}</code></pre>

<p><strong>Note:</strong> It's important to note&nbsp;this file is the one in your&nbsp;root project and not the&nbsp;one in some&nbsp;module.</p>
<img alt="build_root" data-align="center" data-entity-type="file" data-entity-uuid="fb2bf8f4-a812-4870-97c7-dd7afe58110d" src="/sites/default/files/inline-images/build.gradle_0.png" />
<p>The next step is to add the library as dependency, open your build.gradle file in your app module as follows:</p>

<pre>
<code>dependencies {
    implementation 'com.github.raag:TimerView:v0.5.2beta'
}</code></pre>
<img alt="build_app" data-align="center" data-entity-type="file" data-entity-uuid="7e40e34c-f9de-4baa-ac45-3ff6b656bece" src="/sites/default/files/inline-images/build.gradle_app_0.png" />
<p>Click sync and wait until conclude the library download.</p>

<p>&nbsp;</p>

<h2>How to use.</h2>

<p>To use the widget&nbsp;just add a <strong>com.raagpc.TimerView</strong> element in you activity layout (it's a good idea to use fixed dimensions):</p>

<pre>
<code>&lt;com.raagpc.timerview.TimerView
        android:id="@+id/timer"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:textSize="30sp"
        app:maxValue="100"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" /&gt;</code></pre>
<img alt="layout" data-align="center" data-entity-type="file" data-entity-uuid="0721e947-6a89-4f8f-b117-aa2110dc425e" src="/sites/default/files/inline-images/layout_0.png" />
<p>Now you can execute the <strong>start()</strong> method in you activity code.</p>

<pre>
<code>val timer = findViewById&lt;TimerView&gt;(R.id.timer)
timer.start()</code></pre>
<img alt="timer" data-align="center" data-entity-type="file" data-entity-uuid="fa35edb1-b245-4beb-9d60-fbaadf216f6f" src="/sites/default/files/inline-images/timerview_1.gif" style="max-height:350px;" />
<p>&nbsp;</p>

<h2>TimerViewListener; How to get the time events.</h2>

<p>If you want to get the tick event or know when the timer finishes, you can implement the <strong>TimerViewListener </strong>interface, this interface has 2 methods:</p>

<h3>&nbsp;</h3>

<h3>ONTICK(TIME: INT, TIMERVIEW: TIMERVIEW)</h3>

<p>This method is triggered on every tick.</p>

<h4>Params:</h4>

<ul>
	<li>time: the second when the event occurs.</li>
	<li>timerView: the object which trigger the event.</li>
</ul>

<h3>&nbsp;</h3>

<h3>ONFINISH(TIMERVIEW: TIMERVIEW)</h3>

<p>This method is triggered when the timer finishes.</p>

<p>Params:</p>

<ul>
	<li>timerView: the object which trigger the event.</li>
</ul>

<h3>&nbsp;</h3>

<h3>Example:</h3>

<pre>
<code>val listener = object: TimerView.TimerViewListener {
    override fun onTick(time: Int, timerView: TimerView) {
        Log.i("TIMER", "Remaining time: $time")
    }

    override fun onFinish(timerView: TimerView) {
        Log.i("TIMER", "countdown finished!")
    }
}

timer.setTimerViewListener(listener)
timer.start()</code></pre>

<p>&nbsp;</p>

<h2>Attibutes.</h2>

<p>&nbsp;</p>

<div style="width:100%; overflow: auto;">
<table>
	<thead>
		<tr>
			<th>Attribute</th>
			<th>Type</th>
			<th>Description</th>
			<th>Example</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>maxValue</td>
			<td>int</td>
			<td>Max value to graph</td>
			<td>app:maxValue="10"</td>
		</tr>
		<tr>
			<td>value</td>
			<td>int</td>
			<td>Timer initial value</td>
			<td>app:value="5"</td>
		</tr>
		<tr>
			<td>colorPrimary</td>
			<td>color</td>
			<td>Primary color of the graph</td>
			<td>app:colorPrimary="#ff0000"</td>
		</tr>
		<tr>
			<td>colorSecondary</td>
			<td>color</td>
			<td>Secondary color of the graph</td>
			<td>app:colorSecondary="#cccccc"</td>
		</tr>
		<tr>
			<td>timerStrokeWidth</td>
			<td>dimension</td>
			<td>Width of the timer stroke.</td>
			<td>app:timerStrokeWidth="10dp"</td>
		</tr>
		<tr>
			<td>isBackWard</td>
			<td>boolean</td>
			<td>If it's true the timer will be a countdown</td>
			<td>app:isBackward="true"</td>
		</tr>
		<tr>
			<td>textSize</td>
			<td>dimension</td>
			<td>the size of the text.</td>
			<td>app:textSize="20sp"</td>
		</tr>
		<tr>
			<td>padding</td>
			<td>dimension</td>
			<td>padding between the text and the object border.</td>
			<td>app:padding="20dp"</td>
		</tr>
		<tr>
			<td>background</td>
			<td>reference|color</td>
			<td>Background of the element, it can be a color or a drawable.</td>
			<td>app:background="#cccccc"</td>
		</tr>
	</tbody>
</table>
</div>

<p>&nbsp;</p>

<h2>Methods.</h2>

<h3>start()</h3>

<p>Starts the timer.</p>

<p>&nbsp;</p>

<h3>stop()</h3>

<p>Stops the timer.</p>

<p>&nbsp;</p>

<h3>setValue(value: Int)</h3>

<p>Defines the timer initial value.</p>

<h4>parámetros:</h4>

<ul>
	<li><strong>value</strong>: value to set</li>
</ul>

<p>&nbsp;</p>

<h3>setMaxValue(maxValue: Int)</h3>

<p>Defines the maximum value to graph.</p>

<h4>Parámetros:</h4>

<ul>
	<li>maxValue: value to set.</li>
</ul>

<p>&nbsp;</p>

<h3>setIsBackward(isBackward: Boolean)</h3>

<p>Defines if it's a countdown.</p>

<h4>Parámetros:</h4>

<ul>
	<li>isBackward</li>
</ul>

<p>&nbsp;</p>

<h3>setTimerViewListener(listener: TimerViewListener)</h3>

<p>Defines the listener of the object.</p>

<h4>Parámetros:</h4>

<ul>
	<li>listener: TimerViewListener implementation.</li>
</ul>

<h2>&nbsp;</h2>

<h2>Source code.</h2>

<p>The source code it's avaliable in&nbsp;github:</p>

<p><a href="https://github.com/raag/TimerView">https://github.com/raag/TimerView</a></p>
